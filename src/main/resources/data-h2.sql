INSERT INTO tb_exchange_rate (source_currency, target_currency, rate, create_at, update_at) VALUES ("SOL", "DOL", 3.78, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_exchange_rate (source_currency, target_currency, rate, create_at, update_at) VALUES ("SOL", "EUR", 4.10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO tb_invoice (invoice, amount, source_currency, target_currency, rate, create_at, update_at) VALUES ("F001-0012345", 120, "SOL", "DOL", 3.78, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO tb_invoice (invoice, amount, source_currency, target_currency, rate, create_at, update_at) VALUES ("F001-0012345", 180, "SOL", "DOL", 3.78, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);