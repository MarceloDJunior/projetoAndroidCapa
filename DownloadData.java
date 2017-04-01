public class DownloadData {

    public DownloadData() {
    }

    public String downloadDataFromPost(String link, Map<String, String> fields) {

        String data = "";
        String response = "";
        BufferedReader reader = null;

        try {

            for (Map.Entry<String, String> entry : fields.entrySet()) {
                data += URLEncoder.encode(entry.getKey(), "UTF-8")
                        + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
            }

            URL url = new URL(link);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }

            response = sb.toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

        return response;

    }

    public String downloadDataFromLink(String url){

        URL webservice;
        StringBuilder response = null;

        try {
            webservice = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) webservice.openConnection();
            connection.setRequestProperty("charset", "utf-8");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();

        } catch (Exception  e) {
            return "";
        }


        return response.toString();
    }
}