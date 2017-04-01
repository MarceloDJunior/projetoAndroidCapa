//url do web-service
String link = "http://www.exemplo.com.br/login.php";

//map com os campos e valores necessários para o post
Map<String, String> campos = new HashMap<>();
campos.put("login", login);
campos.put("senha", senha);

//resposta
String dados = downloadData.downloadDataFromPost(link, campos);

JSONObject json = new JSONObject(dados);
int dadoInteiro = json.getInt("nomeDoDado");