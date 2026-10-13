create table accounts (
    id uuid primary key default uuidv7(),

    login text unique not null,
    hash text not null
);

create table sellers (
    id uuid primary key default uuidv7(),

    account_id uuid unique not null references accounts(id) on delete cascade,
    ms_token text unique not null
);

create table customers (
    id uuid primary key default uuidv7(),

    account_id uuid unique not null references accounts(id) on delete cascade,
    name text not null
);

create table cart_goods (
    customer_id uuid references customers(id) on delete cascade,
    ms_good_id uuid,

    seller_id uuid not null references sellers(id),
    quantity numeric not null check (quantity > 0),
    added_at timestamptz not null default current_timestamp,

    primary key (customer_id, ms_good_id)
);

create table reviews (
    id uuid primary key default uuidv7(),

    seller_id uuid references sellers(id) on delete cascade,
    customer_id uuid references customers(id) on delete cascade,
    ms_good_id uuid not null,
    rating smallint not null check (rating >= 1 and rating <= 5),
    body text,
    created_at timestamptz not null default current_timestamp
);
