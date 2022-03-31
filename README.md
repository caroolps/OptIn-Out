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
