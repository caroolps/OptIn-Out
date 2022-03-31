# Projeto de Tópicos avançados de banco de dados - Banco de dados - FATEC 2022 - OPTIN/OPTOUT

### DESCRIÇÃO
A loja de esporte "FTSports" para atender a Lei geral da proteção de dados (LGPD), precisa se adequadar a modalidade optIn - optOut, concedendo poder ao cliente em permitir que manipule suas preferências de configurações. Com isso, a loja precisa adequar sua plataforma para que o usuário consiga alterar suas preferências de receber sms, whatsapp ou ligações de ofertas da loja a qualquer momento. E para segurança, todas essas alterações devem ser registradas no banco de dados.

### PROPOSTA
O projeto tem como objetivo atender a LGPD (Lei geral da proteção de dados), apresentando uma solução de configurações de meios de comunicação que um determinado usuário tem o poder de receber ou deixar de receber algumas informações da plataforma, ou seja, OptIn- OptOut. Contudo, a cada alteração nas permissões opt in-out devem ser apresentadas em uma tabela de histórico, descrevendo qual a versão do termo aceitado pelo usuário no momento do seu registro no sistema, e quais foram as opções aceitas, ou não no momento em que este usuário se registrou ou fez alguma alteração em seus dados posteriormente.

### REGRAS DO PROJETO
- Na criação ou alteração do cadastro do usuário irá gerar um registro na tabela Histórico;
- O termo ativo será o último cadastrado no banco de dados com seus detalhes de versão e data de criação;
- Usuário tem o poder de permitir ou não receber sms, ligações e whats de ofertas do sistema;
- No momento da criação ou edição do usuário, é necessário passar a versão do termo que ele está aceitando e registrar na tabela de histórico;
- Dentro do histórico será possível identificar o usuário, suas novas configurações optIn - optOut e qual a versão aceita pelo usuário.

### ENDPOINTS

### Termo

### Criar termo

Endpoint responsavel por criar um termo

**Path**
```
POST <host>/spring-app/termo/new
``` 

**Request** 
```
curl --request POST \
  --url http://localhost:8081/spring-app/termo/new \
  --header 'content-type: application/json' \
  --data '{
	"nome": "Terceiro termo",
	"conteudo": "O super conteudo do meu terceiro termo",
	"versao": "2"
}'
```

**Funcionamento**
![Criar Termo](gifs/criar_termo.gif)


### Get All
Pega todos os termos

**Path**
```
GET <host>/spring-app/termo/all
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/termo/all
```
**Funcionamento**
![Pegar termos](gifs/pegar_todos_termos.gif)


### Get By id
Pega um termo por id

**Path**
```
GET <host>/spring-app/termo/<id_termo>
``` 


**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/termo/1
```

**Funcionamento**
![Pegar por id](gifs/pegar_por_id.gif)

### Get latest
Pega o termo mais recente
**Path**
```
GET <host>/spring-app/termo
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/termo/
```

**Funcionamento**

![Pegar o mais recent](gifs/pegar_o_mais_recente.gif)


### Usuario

### Criar usuario
Cria um usuario

**Path**
```
POST <host>/spring-app/usuario/new
``` 
**Request**
```
curl --request POST \
  --url http://localhost:8081/spring-app/usuario/new \
  --header 'content-type: application/json' \
  --data '{
	"nome": "super usuario",
	"email": "superemai@email.com",
	"cpf": "12312312312",
	"celular": "5512912345678",
	"rua": "super rua",
	"numero": "super numero",
  "bairro": "super bairro",
	"cidade": "super cidade",
	"cep": "12345678",
	"sms": 0,
	"whats": 0,
	"ligacao": 0,
	"termoVersao": 1
}'
```

**Funcionamento**

Criando usuario sem informar termo

![Criando usuario sem informar termo](gifs/criar_usuario_com_termo_inexistente.gif)

Criando usuario com termo antigo

![Criando usuario com termo antigo](gifs/criar_usuario_com_termo_antigo.gif)

Criando usuario

![Criando usuario](gifs/criar_usuario.gif)

### Atualizar usuario
Atualiza um usuario

**Path**
```
PUT <host>/spring-app/usuario/edit
``` 

**Request**

```
curl --request PUT \
  --url http://localhost:8081/spring-app/usuario/edit \
  --header 'content-type: application/json' \
  --data '{
	"id": 1,
	"nome": "super usuario",
	"email": "superemai@email.com",
	"cpf": "12312312312",
	"celular": "5512912345678",
	"rua": "super rua",
	"numero": "super numero",
  "bairro": "super bairro",
	"cidade": "super cidade",
	"cep": "12345678",
	"sms": 2.0,
	"whats": 2.0,
	"ligacao": 2.0,
	"termoVersao": 3
}'
```


**Funcionamento**

Atualizar com termo invalido
![Atualizar com termo invalido](gifs/atualizar_com_termo_invalido.gif)

Atualizar usuario sem alteracoes em config ou termo não gera historico

![Atualizar usuario sem alteracoes em config ou termo não gera historico](gifs/atualizar_usuário_sem_alteracoes_em_config_ou_termo_nao_gera_historico.gif)

Atualizar somente config gera apenas historico de config

![Atualizar somente config gera apenas historico de config](gifs/atualizar_somente_config_gera_historico_apenas_de_config.gif)

Atualizar somente termo gerar apenas historico de termo

![Atualizar somente termo gerar apenas historico de termo](gifs/atualizar_somente_termo_gerar_historico_apenas_de_termo.gif)

Atualizar termo e config gera historico de termo e config

![Atualizar termo e config gera historico de termo e config](gifs/atualizar_termo_config.gif)

### Pegar as configs do usuario
Pega as configs de um usuario

**Path**
```
GET <host>/spring-app/usuario/config/<id_usuario>
``` 
**Request**

```
curl --request GET \
  --url http://localhost:8081/spring-app/usuario/config/1
```

**Funcionamento**

![Pegar configs usuario](gifs/pegar_configs_usuario.gif)


### Pegar termo do usuario
Pega o termo aceito pelo usuario

**Path**
```
GET <host>/spring-app/usuario/termo/<id_usuario>
``` 

**Request**

```
curl --request GET \
  --url http://localhost:8081/spring-app/usuario/termo/1
```

**Funcionamento**

![Pegar termo do usuario](gifs/pegar_usuario_termo.gif)


## Historico

### Pegar todos historicos
Pega todos os historicos

**Path**
```
GET <host>/spring-app/historico/all
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/historico/all
```

**Funcionamento**

![Pegar todos historicos](gifs/pegar_todos_historicos.gif)


### Pegar historico por id
Pega um historico por id

**Path**
```
GET <host>/spring-app/historico/<id_historico>
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/historico/4
```

**Funcionamento**

![Pegar historico por id](gifs/historico_id.gif)


### Pegar historico por usuario

Pega todos os historicos de um usuario

**Path**
```
GET <host>/spring-app/historico/usuario/<id_usuario>
``` 
**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/historico/usuario/1
```

**Funcionameto**
![Pegar historico por usuario](gifs/historico_usuario.gif)

### Historico pelo termo

Pega todos os historicos de um termo

**Path**
```
GET <host>/spring-app/historico/termo/<id_termo>
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/historico/termo/3
```

**Funcionameto**
![Historico pelo termo](gifs/historico_termo.gif)

### Historico por sms
Pega todos os historicos com sms ativo


**Path**
```
GET <host>/spring-app/historico/sms/<valor>
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/historico/sms/2
```

**Funcionameto**
![Historico por sms](gifs/historico_sms.gif)

### Historico pelo whats
Pega todos os historicos com whats

**Path**
```
GET <host>/spring-app/historico/whats/<valor>
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/historico/whats/2
```

**Funcionameto**
![Historico pelo whats](gifs/historico_whats.gif)

### Historico por ligacao

Pega todos os historicos com ligacao ativo


**Path**
```
GET <host>/spring-app/historico/ligacao/<valor>
``` 

**Request**
```
curl --request GET \
  --url http://localhost:8081/spring-app/historico/ligacao/2
```

**Funcionameto**
![Historico por ligacao](gifs/historico_ligacao.gif)
