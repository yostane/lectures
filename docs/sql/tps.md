# Exercices de SQL

- [SQL Murder Mystery](https://mystery.knightlab.com/)

??? Solution

    - Vérifier que le rapport est perdu: `select * from crime_scene_report where date = '20180115' and city = 'SQL City';`
    - List des personnes qui on fait un check-in à la date du crime: 
        
        ```sql
        select * from get_fit_now_member as gfnm 
        join get_fit_now_check_in as gfnci on gfnm.id = gfnci.membership_id
        where check_in_date = '20180115'
        ```
    
    - Interview des personnes qui ont check-in le jour du crime (sur FaceBook ou la gym).

        ```sql
        select * from interview as iw 
        where iw.person_id in (select gfnm.person_id from get_fit_now_member as gfnm 
        join get_fit_now_check_in as gfnci on gfnm.id = gfnci.membership_id
        where check_in_date = '20180115') 
        OR iw.person_id in (select person_id from facebook_event_checkin where date = '20180115')

        -- Ou avec union

        select * from interview as iw 
        where iw.person_id in (select gfnm.person_id from get_fit_now_member as gfnm 
        join get_fit_now_check_in as gfnci on gfnm.id = gfnci.membership_id
        where check_in_date = '20180115' union select person_id from facebook_event_checkin where date = '20180115')
        ```

    On y trouve les témoignages:

    ```txt
    14887	I heard a gunshot and then saw a man run out. He had a "Get Fit Now Gym" bag. The membership number on the bag started with "48Z". Only gold members have those bags. The man got into a car with a plate that included "H42W".
    16371	I saw the murder happen, and I recognized the killer from my gym when I was working out last week on January the 9th.
    67318	I was hired by a woman with a lot of money. I don't know her name but I know she's around 5'5" (65") or 5'7" (67"). She has red hair and she drives a Tesla Model S. I know that she attended the SQL Symphony Concert 3 times in December 2017.
    ``` 

    - On trouve la personne selon le premier témoignage, qui est intriguant

    ```sql
    select * from person as p 
    join get_fit_now_member as gfnm on p.id = gfnm.person_id and gfnm.id like '48Z%' and membership_status = 'gold'
    join drivers_license as dl on dl.id = p.license_id and dl.plate_number like '%H42W%'
    ```

    - La solution est donc: "Jeremy Bowers"

- [SQL Studio Ghibli](https://dquenton.forge.apps.education.fr/nsi-terminale-specialite/BaseDeDonnees/Ghibli_SQL/)
    - Recommencer la même sélection, mais en faisant un tri croissant sur l'âge des personnages. -> `select nom, cast(age as INTEGER) as a from personnage order by a`
    - Afficher maintenant les titres des 5 films les plus courts ainsi que leur durée. -> `select titre, duree from film order by duree limit 5`
    - Afficher le nombre de personnages -> `select count(*) from personnage`
    - Afficher la liste des films réalisés entre les années 1995 et 2005 exclues. -> `select * from film  where 1995 < date_sortie < 2005`
    - Afficher les films réalisés par «Hayao Miyazaki» -> `select f.* from film as f join personne as p on p.id = f.id_realisateur where p.nom = "Hayao Miyazaki"`
    - Compter le nombre de films réalisés par «Isao Takahata» -> `select count(*) from film as f join personne as p on p.id = f.id_realisateur where p.nom like "Isao Takahata"`
- [Sum and count (Group by and having)](https://sqlzoo.net/wiki/SUM_and_COUNT)