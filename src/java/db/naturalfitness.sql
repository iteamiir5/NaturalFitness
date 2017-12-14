use naturalfitness;

create table utilisateur(
	id int primary key,
    login varchar(50),
    mdp varchar(50),
    nom varchar(50),
    prenom varchar(50),
    email varchar(50),
    tel varchar(15)
);

create table adherent(
	id int primary key,
    cin varchar(50),
    sexe varchar(50),
    dateNaissance date,
    constraint fk_user foreign key(id) references utilisateur(id)
);

create table abonnement(
	id int primary key,
    idAdherent int,
    idCours int,
    dateDebut date,
    dateFin date,
    prix int,
    constraint fk_adh foreign key(id) references adherent(id),
    constraint fk_cours foreign key(id) references cours(id)
);

create table admin(
	id int primary key,
	constraint fk_admin foreign key(id) references utilisateur(id)
);

create table secretaire(
	id int primary key,
	constraint fk_secretaire foreign key(id) references utilisateur(id)
);

create table cours(
	id int primary key,
	nomCours varchar(100)
);

create table planing(
	id int primary key,
	idCours int,
	datePlaning Date,
	heureD varchar(10),
	heureF varchar(10),
	constraint fk_cour foreign key(id) references cours(id)
);