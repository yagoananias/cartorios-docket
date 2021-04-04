INSERT INTO cartorios (cartorio_id, endereco, nome) VALUES
  ( 1000, 'Av. Paulista, 3000', 'Cartorio de Registro Civil'),
  ( 1001, 'Av. Brasil, 4000', 'Cartorio da Penha de Franca'),
  ( 1002, 'Av. Aricanduva, 5000', 'Cartorio de Notas de Sao Paulo');


INSERT INTO certidoes (cert_id, nome) VALUES
  ( 1000, 'Nascimento'),
  ( 1001, 'Casamento'),
  ( 1002, 'Obito');


INSERT INTO cartorio_certidao (cartorio_id, certidao_id) VALUES
  ( 1000, '1000'),
  ( 1000, '1002'),
  ( 1000, '1001'),
  ( 1001, '1000'),
  ( 1001, '1002'),
  ( 1001, '1001'),
  ( 1002, '1000'),
  ( 1002, '1002'),
  ( 1002, '1001');
