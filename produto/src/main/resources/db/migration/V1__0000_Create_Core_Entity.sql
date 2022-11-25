create table tb_estoque
(
    id                     bigint auto_increment
        primary key,
    qt_prod_estoque        int          null,
    nm_local_estoque varchar(255) null,
    status_permissao_venda varchar(255) null
);

create table tb_produto
(
    id            bigint auto_increment
        primary key,
    description   varchar(255) null,
    dt_vencimento datetime(6)  null,
    name          varchar(255) null,
    price         float        not null,
    statusp       varchar(255) null,
    estoque_id    bigint       null,
    constraint FK3y4b2oh0d7f56i2ytgc65ce19
        foreign key (estoque_id) references tb_estoque (id)
);


