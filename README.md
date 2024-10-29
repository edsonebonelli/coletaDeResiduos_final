<h1>API Documentation - FIAP - Coleta de Lixo</h1>

<h2>Sumário</h2>
<ol>
<li><a href="#introdu%C3%A7%C3%A3o">Introdução</a></li>
<li><a href="#autentica%C3%A7%C3%A3o">Configurações dos BD</a></li>
<li><a href="#autentica%C3%A7%C3%A3o">Autenticação</a></li>
<li><a href="#endpoints">End Points</a></li>
<li><a href="#c%C3%B3digos-de-status">Códigos de Status</a></li>
<li><a href="#exemplos-de-uso">Exemplos de Uso</a></li>
<li><a href="#erros-comuns">Erros Comuns</a></li>
</ol>

<hr>

<h2><a id="introdu%C3%A7%C3%A3o"></a>Introdução</h2>

<p>Bem-vindo à documentação da <strong>Rotas de Coleta API</strong>. Esta API permite que você interaja com o nosso serviço de maneira programática. Utilize os endpoints listados abaixo para realizar operações como <strong>cadastrar nova rota ou cliente</strong>, <strong>atualizar rota ou cliente</strong>, <strong>consultar rota ou cliente</strong> e <strong>excluir rota ou cliente</strong> dados.</p>

<p>Base URL da API: </p>
<pre><code>http://localhost:8080/api
</code></pre>

<hr>

<h2><a id="autentica%C3%A7%C3%A3o"></a>Configurações dos BD</h2>

<p>Banco de dados tem que ser configurado no arquivo application.properties</p>

<p>Caminho do arquivo src/main/java/br.com.fiap.coleDeLixo/resources/application.properties</p>

### ORACLE BD ###

>spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
>
>spring.datasource.username=RM000000
>
>spring.datasource.password=ddmmyy
>
>spring.flyway.baselineOnMigrate=true
>
>spring.jpa.show-sql=true
>
>spring.jpa.properties.hibernate.format_sql=true

### BANCO DE DADOS H2 ###

>spring.datasource.url=jdbc:h2:mem:DB_API_COLETA
>
>spring.datasource.driverClassName=org.h2.Driver
>
>spring.datasource.username=sa
>
>spring.datasource.password=sem senha
>
>spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
>
>spring.h2.console.enabled=true
>
>
>spring.h2.console.path=/h2-console</p>

<hr>

<p>Base URL para acessar o banco de dados H2: </p>
<pre><code>http://localhost:8080/h2-console
</code></pre>

<hr>

<h2><a id="autentica%C3%A7%C3%A3o"></a>Autenticação</h2>

<p>Esta API utiliza <strong>autenticação baseada em tokens</strong> (ex: JWT) para verificar as permissões dos usuários. Para cada requisição, você deve incluir o token de autenticação no cabeçalho da requisição.</p>

<h3>Exemplo de Cabeçalho de Autenticação</h3>
<pre><code>Authorization: Bearer {seu_token_aqui}
</code></pre>

<h3>Obtendo o Token</h3>
<p>O token pode ser obtido através do endpoint de login:</p>
<pre><code>POST /auth/login
</code></pre>
<p>Envie suas credenciais no corpo da requisição e receba o token de acesso.</p>

<hr>

<h2><a id="endpoints"></a>Endpoints</h2>

<h4>Login</h4>
<pre><code>curl -X POST "http://localhost:8080/auth/login"
</code></pre>

<h4>Corpo da requisição</h4>
<ul>
<li><strong>Código 200 - OK</strong></li>
</ul>
<pre><code>
{
  "email": "usuario@exemplo.com",
  "senha": "12345678",
}
</code></pre>

<hr>

<h4>Registrar Usuário</h4>
<pre><code>curl -X POST "http://localhost:8080/auth/register"
</code></pre>

<h4>Corpo da requisição</h4>
<ul>
<li><strong>Código 200 - OK</strong></li>
</ul>
<pre><code>
{
	"nome": "FABIANA MOREIRA",
  "email": "usuario@exemplo.com",
  "senha": "12345678",
	"role": "ADMIN"
}
</code></pre>

<hr>

<h4>Cadastrar Cliente</h4>
<pre><code>curl -X POST "http://localhost:8080/api/clientes"
</code></pre>

<h4>Corpo da requisição</h4>
<ul>
<li><strong>Código 200 - OK</strong></li>
</ul>
<pre><code>
{
  "CLIENTE_ID": 123,
  "NOME": "João Silva",
	"CPF": "39729950931",
  "EMAIL": "joao.silva@email.com",
	"SENHA": "jOAO@1993",
  "TELEFONE": "+55 11 91234-5678",
  "DATA_DE_CADASTRO": "1990-01-15",
  "STATUS_CLIENTE": "Ativo",
	"TIPO_CLIENTE": "Pessoa Física"
}
</code></pre>

<hr>

<h4>Buscar Cliente pelo ID</h4>
<pre><code>curl -X GET "http://localhost:8080/api/clientes/4"
</code></pre>

<hr>

<h4>Atualizar Cliente</h4>
<pre><code>curl -X PUT "http://localhost:8080/api/cliente/4"
</code></pre>

<h4>Corpo da requisição</h4>
<ul>
<li><strong>Código 200 - OK</strong></li>
</ul>
<pre><code>
{
  "CLIENTE_ID": 123,
  "NOME": "João Silva",
	"CPF": "39729950931",
  "EMAIL": "joao.silva@hotmail.com",
	"SENHA": "jOAO@1993",
  "TELEFONE": "+55 11 91234-5879",
  "DATA_DE_CADASTRO": "1990-01-15",
  "STATUS_CLIENTE": "Ativo",
	"TIPO_CLIENTE": "Pessoa Juridica"
}
</code></pre>

<hr>

<h4>Excluir Cliente</h4>
<pre><code>curl -X DELETE "http://localhost:8080/api/clientes/4"
</code></pre>

<hr>

<h4>Cadastro de Rotas</h4>
<pre><code>curl -X POST "http://localhost:8080/api/rotas"
</code></pre>

<h4>Corpo da requisição</h4>
<ul>
<li><strong>Código 200 - OK</strong></li>
</ul>
<pre><code>
{
  "rotasDeColeta": [
    {
      "id": 1,
      "nomeRota": "Rota Norte",
      "localInicio": "Rua Amazonas, 123",
      "localFim": "Avenida Brasil, 456",
      "horarioInicio": "08:00",
      "horarioFim": "12:00",
      "diasDeOperacao": ["Segunda-feira", "Quarta-feira", "Sexta-feira"]
    },
    {
      "id": 2,
      "nomeRota": "Rota Sul",
      "localInicio": "Rua das Flores, 789",
      "localFim": "Avenida Paulista, 1000",
      "horarioInicio": "13:00",
      "horarioFim": "18:00",
      "diasDeOperacao": ["Terça-feira", "Quinta-feira"]
    },
    {
      "id": 3,
      "nomeRota": "Rota Leste",
      "localInicio": "Praça da Liberdade, 55",
      "localFim": "Rua XV de Novembro, 200",
      "horarioInicio": "06:00",
      "horarioFim": "10:00",
      "diasDeOperacao": ["Segunda-feira", "Quarta-feira", "Sábado"]
    }
  ]
}
</code></pre>

<hr>

<h4>Listar Todas As Rotas Cadastradas</h4>
<pre><code>curl -X GET "http://localhost:8080/api/rotas"
</code></pre>

<hr>

<h4>Buscar rotas pelo ID</h4>
<pre><code>curl -X GET "http://localhost:8080/api/rotas/1"
</code></pre>

<hr>

<h4>Atualizar Rotas pelo ID</h4>
<pre><code>curl -X PUT "http://localhost:8080/api/rotas/2"
</code></pre>

<h4>Corpo da requisição</h4>
<ul>
<li><strong>Código 200 - OK</strong></li>
</ul>
<pre><code>
{
  "rotaDeColeta": {
    "id": 4,
    "nomeRota": "Rota Nordeste",
    "localInicio": "Rua Amazonas, 123",
    "localFim": "Avenida Brasil, 456",
    "horarioInicio": "08:00",
    "horarioFim": "12:00",
    "diasDeOperacao": ["Quarta-feira", "Sexta-feira"]
  }
}
</code></pre>

<hr>

<h4>Excluir Uma Rota Pelo ID</h4>
<pre><code>curl -X DELETE "http://localhost:8080/api/rotas/2"
</code></pre>

<hr>

<h2><a id="c%C3%B3digos-de-status"></a>Códigos de Status</h2>

<table>
<thead>
<tr>
<th>Código</th>
<th>Descrição</th>
</tr>
</thead>
<tbody>
<tr>
<td><code>200</code></td>
<td>Requisição bem-sucedida</td>
</tr>
<tr>
<td><code>201</code></td>
<td>Recurso criado com sucesso</td>
</tr>
<tr>
<td><code>400</code></td>
<td>Requisição inválida (parâmetros faltando/incorretos)</td>
</tr>
<tr>
<td><code>401</code></td>
<td>Não autorizado (token inválido ou ausente)</td>
</tr>
<tr>
<td><code>403</code></td>
<td>Acesso negado (permissões insuficientes)</td>
</tr>
<tr>
<td><code>404</code></td>
<td>Recurso não encontrado</td>
</tr>
<tr>
<td><code>500</code></td>
<td>Erro interno no servidor</td>
</tr>
</tbody>
</table>

<hr>

<h3>Usando Postman</h3>
<ol>
<li>Abra o Postman.</li>
<li>Crie uma nova requisição.</li>
<li>Defina o método (<code>GET</code>, <code>POST</code>, <code>DEL</code>, <code>PUL</code> etc.) e a URL do endpoint.</li>
<li>Adicione o cabeçalho <code>Authorization</code> com o token JWT.</li>
<li>No caso de <code>POST</code> ou <code>PUT</code>, defina o corpo da requisição em formato JSON.</li>
</ol>

<hr>

<h3>Usando Insomnia</h3>
<ol>
<li>Abra o Insomnia.</li>
<li>Crie uma nova requisição.</li>
<li>Defina o método (<code>GET</code>, <code>POST</code>, <code>DEL</code>, <code>PUL</code> etc.) e a URL do endpoint.</li>
<li>Adicione o cabeçalho <code>Authorization</code> com o token JWT.</li>
<li>No caso de <code>POST</code> ou <code>PUT</code>, defina o corpo da requisição em formato JSON.</li>
</ol>

<hr>

<h2><a id="erros-comuns"></a>Erros Comuns</h2>

<ul>
<li><strong>401 Unauthorized:</strong> O token de autenticação não foi enviado ou é inválido.
