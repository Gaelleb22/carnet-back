--user
insert into user (uuid, pseudo, password) values ('283fae3e9e3747fb9233c3ff8b5abfe8', 'user1', 'password');
insert into user (uuid, pseudo, password) values ('f0442be9138b4174b07bb8588b24830f', 'user2', 'password');

--recette
insert into recette (uuid, nom, temps_preparation, cuisson, temps_cuisson, type_cuisson, repos, classement, statut, user_uuid) values ('12625d8b322b484f81aa4767d2f812c8', 'fondant au chocolat', 60, TRUE, 30, 0, FALSE, 5, 1, '283fae3e9e3747fb9233c3ff8b5abfe8');
insert into recette (uuid, nom, temps_preparation, cuisson, temps_cuisson, type_cuisson, repos, classement, statut, user_uuid) values ('f1f9250f4d354d5ab7b0ff064d8c3717', 'soupe de potiron', 45, TRUE, 30, 2, FALSE, 3, 0, '283fae3e9e3747fb9233c3ff8b5abfe8');
insert into recette (uuid, nom, temps_preparation, cuisson, temps_cuisson, repos, classement, statut, user_uuid) values ('ae618596420c49d1a28a220be06defd1', 'glaçage au beurre', 15, FALSE, 0, FALSE, 2, 0, 'f0442be9138b4174b07bb8588b24830f');
insert into recette (uuid, nom, temps_preparation, cuisson, temps_cuisson, type_cuisson, repos, classement, statut, user_uuid) values ('22eef239cede4b658c7c957dca52b1ed', 'langue de chat', 30, TRUE, 9, 0, FALSE, 4, 0, 'f0442be9138b4174b07bb8588b24830f');

--ingrédients
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('231cd90af62b4ac281125ba25ea420db', 'oeuf', '2', '12625d8b322b484f81aa4767d2f812c8');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('a69336fcee5c45879e3ec5956e2c5546', 'beurre', '100 gramme', '12625d8b322b484f81aa4767d2f812c8');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('e261807d5aa04c8cbacbb6f28dfd36bf', 'chocolat', '200 gramme', '12625d8b322b484f81aa4767d2f812c8');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('59e725d825c740188672e931d44186a1', 'farine', '100 gramme', '22eef239cede4b658c7c957dca52b1ed');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('f6e8cc45fe87414eb3873e09fb312486', 'sucre glace', '150 gramme', 'ae618596420c49d1a28a220be06defd1');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('a479bba3f66345b7bd5c5b60c7281f49', 'potiron', '1', 'f1f9250f4d354d5ab7b0ff064d8c3717');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('b38194c90d97474c9d375c4890aaeabd', 'eau', '500 ml', 'f1f9250f4d354d5ab7b0ff064d8c3717');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('a66b5cb102f644998806d6e42e0c204a', 'sucre', '150 gramme', '22eef239cede4b658c7c957dca52b1ed');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('000ef271f4e94ce9a3b3b7939bec1621', 'extrait de vanille', '10 gouttes', '22eef239cede4b658c7c957dca52b1ed');
insert into ingredient (uuid, nom, quantite, recette_uuid) values ('0f4b94b13dfa463f8076f101033569d2', 'oignon', '1', 'f1f9250f4d354d5ab7b0ff064d8c3717');

--étapes
insert into etapes (uuid, texte, recette_uuid) values ('c941d7658c994a81979078eb262efe7b', 'Eplucher et couper l''oignon et le potimaron.', 'f1f9250f4d354d5ab7b0ff064d8c3717');
insert into etapes (uuid, texte, recette_uuid) values ('016e30e4f69b4be1af68085202206106', 'Faire cuire 30 min dans une casserole avec de l''eau.', 'f1f9250f4d354d5ab7b0ff064d8c3717');
insert into etapes (uuid, texte, recette_uuid) values ('4710a4aa2bef4c84ab1c8d2525a00f95', 'Retirer du feu et mixer la soupe.', 'f1f9250f4d354d5ab7b0ff064d8c3717');

--astuce
insert into astuce (uuid, astuce, recette_uuid) values ('961ecefe58224a868d5d426fd647d43e', 'Ajouter un cube de légume pour plus de goût !', 'f1f9250f4d354d5ab7b0ff064d8c3717');

--conseil
insert into conseil (uuid, texte, categorie) values ('7062d63d4a744047868159fdf8dd32eb', 'Pour éplucher des tomates, cisailler la peau en forme de croix avant de les plonger quelques secondes dans l''eau bouillante.', 'légumes');
insert into conseil (uuid, texte, categorie) values ('fa8a668f74934aa29bd6d22c1f60a066', 'Quelques idées de recettes sucrés pour ne pas jeter les blancs d''oeuf : langues de chat, meringue', 'sucré');

--citation
insert into citation (uuid, auteur, citation) values ('89297e55ba9b40b7bb108bce6045d40a', 'Paul Bocuse', 'Il n''y a pas de bonne cuisine si au départ elle n''est pas faite par amitié pour celui ou celle à qui elle est destinée.');
insert into citation (uuid, auteur, date, citation) values ('05f39f151f4143809a667547c38abab4', 'La soupe aux choux', '1981-01-01', 'Avec quoi tu as soupé hier? Un pied de cochon Il n''y a pas plus lourd pour l''estomac! Alors...ta soucoupe...c''est le pied de cochon!');