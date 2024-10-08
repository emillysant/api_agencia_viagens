# api_agencia_viagens

# APIGerenciamentodeViagenseDestinos

## Descrição:

Você deve criar uma API gerenciar viagens e destinos.A API deve implementar uma
relação de um para muitos (1-N) entre duas entidades: Destino e Viagem.

## Modelos:

1. Destino:
   ○ id:Long(identificador único do destino)
2. Viagem:
   ○ id:Long(identificador único da viagem)

## RequisitosdaAPI?

1. EndpointsparaDestino:
   ○ GET/destinos:Retorna a lista de todos os destinos.
   ○ GET/destinos/{id}:Retorna os detalhes de um destino específico.
   ○ POST/destinos:Cria um novo destino.
   ○ PUT/destinos/{id}:Atualiza as informações de um destino existente.
   ○ DELETE/destinos/{id}:Remove um destino específico.
2. EndpointsparaViagem:
   ○ GET/viagens:Retorna a lista de todas as viagens.
   ○ GET/viagens/{id}:Retorna os detalhes de uma viagem específica.
   ○ POST/viagens:Cria uma nova viagem.O campo "destino" deve ser
   preenchido como ID do destino existente.
   ○ PUT/viagens/{id}:Atualiza as informações de uma viagem existente.
   ○ DELETE/viagens/{id}:Remove uma viagem específica.
   ○ GET/destinos/{destinoId}/viagens:Retorna todas as viagens associadas
   a um determinado destino.

## RequisitosAdicionais:

```
● Configure os relacionamentosentreasentidadesDestinoeViagemusando
anotações do JPA (@ManyToOnee@OneToMany).
● Adicione validação básica para garantir que o título da viagem,o nome do
destino e o país sejam informados,e que as datas da viagem estejam em uma
ordem corret a(data de início antes da  data de término).
● Utilize a abordagem de DTOs (DataTransferObjects) para transferir dados
entre a API e o cliente.
● Criemais 2 endopointsasuaescolha(comentenocódigoqualafunçãodele)
```


