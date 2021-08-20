create table companies (uuid varchar(255) not null, city varchar(255), company_contact varchar(255), company_id varchar(20), createdat varchar(35), email varchar(100), name varchar(100), phone varchar(15), postal_code varchar(8), street varchar(255), updatedat varchar(35), primary key (uuid));
create table company_budget (uuid varchar(255) not null, createdat varchar(35), daily_budget double not null, monthly_budget double not null, updatedat varchar(35), weekly_budget double not null, yearly_budget double not null, target_company_uuid varchar(255) not null, primary key (uuid));
create table customers (uuid varchar(255) not null, city varchar(255), createdat varchar(255), first_name varchar(255), last_name varchar(255), phone bigint not null, postal_code varchar(255), street varchar(255), updatedat varchar(255), primary key (uuid));
create table login_time (uuid varchar(255) not null, createdat varchar(255), updatedat varchar(255), target_user_uuid varchar(255), primary key (uuid));
create table orders (uuid varchar(255) not null, createdat varchar(255), order_number bigint, updatedat varchar(255), target_customer_uuid varchar(255), target_user_uuid varchar(255), primary key (uuid));
create table products (uuid varchar(255) not null, comission integer not null, createdat varchar(255), monthly_subscription boolean not null, name varchar(255), price integer not null, product_vendor varchar(255), seller_comission integer not null, type varchar(255), updatedat varchar(255), target_company_uuid varchar(255) not null, primary key (uuid));
create table products_orders (products_uuid varchar(255) not null, orders_uuid varchar(255) not null);
create table subscription_plans (uuid varchar(255) not null, createdat varchar(255), monthly_price integer not null, name varchar(255), updatedat varchar(255), primary key (uuid));
create table teams (uuid varchar(255) not null, team_name varchar(150), target_company_uuid varchar(255), primary key (uuid));
create table user_budget (uuid varchar(255) not null, createdat varchar(35), daily_budget double not null, monthly_budget double not null, updatedat varchar(35), weekly_budget double not null, yearly_budget double not null, target_user_uuid varchar(255) not null, primary key (uuid));
create table usermodules (uuid varchar(255) not null, createdat varchar(50), name varchar(255), updatedat varchar(50), primary key (uuid));
create table users (uuid varchar(255) not null, business_role varchar(60), createdat varchar(50), email varchar(150), name varchar(150), password varchar(65), updatedat varchar(50), user_role varchar(50), target_company_uuid varchar(255), target_subscription_plan_uuid varchar(255), target_team_uuid varchar(255), primary key (uuid));
create table users_usermodules (usermodules_id varchar(255) not null, users_id varchar(255) not null);
alter table orders add constraint UK_nthkiu7pgmnqnu86i2jyoe2v7 unique (order_number)
alter table company_budget add constraint FKmr9wey3nt2884vgdxx6kadn65 foreign key (target_company_uuid) references companies
alter table login_time add constraint FKnjuh1lii3uo4wv40n9b9uhrer foreign key (target_user_uuid) references users
alter table orders add constraint FKiwis58vo3qi9cbbs2qnfnkxgj foreign key (target_customer_uuid) references customers
alter table orders add constraint FKf2n94q5a6v78eg16cdomamrdn foreign key (target_user_uuid) references users
alter table products add constraint FKbpr7qj4ey8qad1977v7l8p4uw foreign key (target_company_uuid) references companies
alter table products_orders add constraint FK96780476a6dowwu54fhaopd3f foreign key (orders_uuid) references orders
alter table products_orders add constraint FKbj24ms9f858qeaigjcr79iw0m foreign key (products_uuid) references products
alter table teams add constraint FKlgvfpqd36ckpqx9fkbvjx9db5 foreign key (target_company_uuid) references companies
alter table user_budget add constraint FKt589ek3m5px7ivd83yrs4iour foreign key (target_user_uuid) references users
alter table users add constraint FK3yrbk2jeiufx2bqmim0q0m8x6 foreign key (target_company_uuid) references companies
alter table users add constraint FKncthuyfh351l19pnxgr8nbn3 foreign key (target_subscription_plan_uuid) references subscription_plans
alter table users add constraint FKe920ehdr54j9vyot89nuqksi foreign key (target_team_uuid) references teams
alter table users_usermodules add constraint FK1lpmtcnlf113ssksm9fh2g9xi foreign key (users_id) references users
alter table users_usermodules add constraint FK3kdh3wwru6fsss29kfyx19y94 foreign key (usermodules_id) references usermodules