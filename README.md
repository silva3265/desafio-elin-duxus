
# Desafio de Desenvolvimento

O Objetivo deste desafio é criar um Sistema Web bem parecido com o Cartola FC, onde toda a semana se forma um time vencedor
  *Exemplo: Futebol, Basquete, Couter Strike...

# Minha Jornada no Desafio:

- Aproveitei os diversos codigos pré prontos para poder fazer apenas a implementação das funcionalidades, economizando tempo
- Usei o meu tempo maior para focar no Tratamento de Dados e Persisti-los no banco

- Como solicitado, deixei as telas por ultimo e pensei na Estrura de Dados e nos Métodos
- Ultilizei os Testes Unitarios ja pré prontos

- No decorrer da semana fiz os Commits de forma frequente para mostrar a minha evolução
- Sobre banco de dados, ultilizei o banco MySQL

# Como Testar a Aplicação
 1. Clone o repositorio
 2. Faça uma Base de Dados MySql
 3. Crie as Tabelas Executando os Codigos Abaixo:

create table time(

id bigint not null primary key auto_increment,
data date

);

create table integrante(

id bigint not null primary key auto_increment,
franquia varchar(100) not null,
nome varchar(100) not null,
funcao varchar(100) not null

);

create table composicao_time(

id bigint not null primary key auto_increment,
time_id bigint not null,
integrante_id bigint not null,
constraint fk_time_composicao_time foreign key (time_id) references time(id),
constraint fk_integrante_composicao_time foreign key (integrante_id) references integrante(id)

);

 5. Execute o Projeto em um servidor
 6. Acesse as rotas:
    Exemplo de Data: 14-01-2023
    Exemplo de Data Inicial e Data Final: 01-01-2021 e 20-01-2021
    
   - Consulta: timeDaData: http://localhost:8080/duxusDesafio/time/timeData/{data}
    
   - Consulta: integranteMaisUsado: http://localhost:8080/duxusDesafio/integrante/maisUsado?dataInicial={datainicial}&dataFinal={dataFinal}
    
   - Consulta: timeMaisComum: http://localhost:8080/duxusDesafio/time/timeMaisComum?dataInicial={datainicial}&dataFinal={dataFinal}
    
   - Consulta: funcaoMaisComum: http://localhost:8080/duxusDesafio/integrante/funcaoMaisComum?dataInicial={datainicial}&dataFinal={dataFinal}
    
   - Consulta: franquiaMaisComum: http://localhost:8080/duxusDesafio/time/franquiaMaisComum?dataInicial={datainicial}&dataFinal={dataFinal}
    
   - Consulta: contagemFranquia: http://localhost:8080/duxusDesafio/time/contagemFranquia?dataInicial={datainicial}&dataFinal={dataFinal}
    
   - Consulta: contagemPorFuncao: http://localhost:8080/duxusDesafio/integrante/contagemPorFuncao?dataInicial={datainicial}&dataFinal={dataFinal}
    
   - Inserir: cadastroIntegrante: http://localhost:8080/duxusDesafio/integrante/cadastro (** Via Navegador)
   - Consulta: visualizarIntegrantes: http://localhost:8080/duxusDesafio/integrante/visualizar (** Via Navegador)
    
## Contato:
 Caso haja alguma duvida em relação ao Sistema acima fique a vontade para entrar em contato, [silva3265@gmail.com](mailto:silva3265@gmail.com) ou 
 [linkedin](https://www.linkedin.com/in/r%C3%B4mulo-albuquerque-869b2a1a2/)
 
   

