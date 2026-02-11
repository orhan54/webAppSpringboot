-- Création de la table
CREATE TABLE users (
    id_users INT AUTO_INCREMENT PRIMARY KEY,
    user_first_name VARCHAR(50) NOT NULL,
    user_last_name VARCHAR(50) NOT NULL
);

-- Insertion de 20 personnes
INSERT INTO users (user_first_name, user_last_name) VALUES
    ('Jean', 'Dupont'),
    ('Marie', 'Martin'),
    ('Paul', 'Durand'),
    ('Luc', 'Moreau'),
    ('Sophie', 'Bernard'),
    ('Claire', 'Petit'),
    ('Thomas', 'Robert'),
    ('Emma', 'Richard'),
    ('Lucas', 'Dubois'),
    ('Julie', 'Leroy'),
    ('Antoine', 'Roux'),
    ('Camille', 'Fontaine'),
    ('Nicolas', 'Chevalier'),
    ('Laura', 'Blanc'),
    ('Julien', 'Garnier'),
    ('Manon', 'Faure'),
    ('Alexandre', 'Renaud'),
    ('Chloé', 'Lambert'),
    ('Maxime', 'Marchand'),
    ('Sarah', 'Henry');
