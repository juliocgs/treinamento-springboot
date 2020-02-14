--------------------EXERCICIO--------------------------------------

Com base em tudo que aprendemos, crie o BACKEND completo com todos ENDPOINTS necessários para um CRUD:
 Inclusão
 Delete (Exclusão Lógica)
 Alteração
 Consulta paginada (Filtro – Nome do curso)
 Consultar todos (Sem ser paginado)

RN´s: Não é possível inserir um curso com o mesmo nome e categoria,  superior a 5 anos de duração. Trate caso sua pesquise não retorne nada com “Nenhum registro encontrado.”

Todas as operações devem GRAVAR LOG – Nome da pessoa logada + dataHora na base de dados + Id do Curso + Ação.

Campos para cadastro – Nome do curso, Categoria, tempo de duração do curso em anos, habilitado para PCD?

--------------------TABELAS----------------------------------------

CREATE TABLE tb_categoria_curso
(
   id BIGINT PRIMARY KEY not null,
   descricao VARCHAR(255)
);


CREATE TABLE tb_curso
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(200) not null,
    pcd VARCHAR(1) not null,
    duracao INT(1) not null,
    categoria_id BIGINT not null,
    ativo VARCHAR(1) not null,
    FOREIGN KEY (categoria_id) REFERENCES tb_categoria_curso(id)
);

CREATE TABLE tb_log_curso
(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    acao VARCHAR(1) not null,
    nome_usuario VARCHAR(100) not null,
    data_hora datetime not null,
    curso_id BIGINT not null,
    FOREIGN KEY (curso_id) REFERENCES tb_curso(id)

);

CREATE TABLE tb_usuario
(
   id BIGINT PRIMARY KEY not null AUTO_INCREMENT,
   email VARCHAR(200) not null,
   nome VARCHAR(200) not null,
   senha VARCHAR(200) not null
);

--------------URL PARA RECUPERAR TOKEN ------------------------------------

http://localhost:8090/treinamento/oauth/token?grant_type=password&username=roberto.junior@castgroup.com.br&password=admin

----------------COMANDOS DOCKER---------------------------------
docker container ps
docker container ps -a
docker image ls
docker container stop/start/rm {nome_container}
docker image rm {nome_image}
docker image build -t image_backend . - CRIAR UMA IMAGEM COM BASE EM UM DOCKERFILE
docker container run -d -p 7000:8090 --name container_backend --network {nome da rede} image_backend 
docker network ls
docker network connect {nome_container}
docker network create {nome da rede}
docker container inspect {nome_container}
docker container logs {nome_container}
docker container stats