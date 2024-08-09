# api_agencia_viagens

# APIGerenciamentodeViagenseDestinos

## Descrição:

VocêdevecriarumaAPIgerenciarviagensedestinos.AAPIdeveimplementaruma
relaçãodeumparamuitos(1-N)entreduasentidades:DestinoeViagem.

## Modelos:

1. Destino:
   ○ id:Long(identificadorúnicododestino)
2. Viagem:
   ○ id:Long(identificadorúnicodaviagem)

## RequisitosdaAPI?

1. EndpointsparaDestino:
   ○ GET/destinos:Retornaalistadetodososdestinos.
   ○ GET/destinos/{id}:Retornaosdetalhesdeumdestinoespecífico.
   ○ POST/destinos:Criaumnovodestino.
   ○ PUT/destinos/{id}:Atualizaasinformaçõesdeumdestinoexistente.
   ○ DELETE/destinos/{id}:Removeumdestinoespecífico.
2. EndpointsparaViagem:
   ○ GET/viagens:Retornaalistadetodasasviagens.
   ○ GET/viagens/{id}:Retornaosdetalhesdeumaviagemespecífica.
   ○ POST/viagens:Criaumanovaviagem.Ocampo"destino"deveser
   preenchidocomoIDdodestinoexistente.
   ○ PUT/viagens/{id}:Atualizaasinformaçõesdeumaviagemexistente.
   ○ DELETE/viagens/{id}:Removeumaviagemespecífica.
   ○ GET/destinos/{destinoId}/viagens:Retornatodasasviagensassociadas
   aumdeterminadodestino.

## RequisitosAdicionais:

```
● ConfigureosrelacionamentosentreasentidadesDestinoeViagemusando
anotaçõesdoJPA(@ManyToOnee@OneToMany).
● Adicionevalidaçãobásicaparagarantirqueotítulodaviagem,onomedo
destinoeopaíssejaminformados,equeasdatasdaviagemestejamemuma
ordemcorreta(datadeinícioantesdadatadetérmino).
● UtilizeaabordagemdeDTOs(DataTransferObjects)paratransferirdados
entreaAPIeocliente.
● Criemais 2 endopointsasuaescolha(comentenocódigoqualafunçãodele)
```


