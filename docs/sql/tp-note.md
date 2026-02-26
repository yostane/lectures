# TP noté posts et commentaires

Développer une application permettant à des utilisateurs enregistrés de poster des articles et des commentaires. 

- Utiliser supabase pour la partie backend.
    - Deux tables : `posts` et `comments` avec une relation entre les deux (un post peut avoir plusieurs commentaires, un commentaire appartient à un seul post). (1)
    - Les posts et les commentaires doivent être liés à l'utilisateur qui les a créés (via une relation avec la table `auth.users` de supabase). (1)
    - Les admins sont identifiés par un email en `@admin.mydomain.com`.
    Implémenter les RLS pour que :
        - Tout le monde peux lire les articles et les commentaires, mais seuls les utilisateurs authentifiés peuvent en poster. (2)
        - Seuls les admins peuvent supprimer des articles ou des commentaires. (2)
- Implémenter le front-end avec la technologie de votre choix. 
    - Pour permettre aux utilisateurs de s'inscrire, de se connecter, de poster des articles et des commentaires, et pour les admins de supprimer des articles ou des commentaires. (4)
    - Utilisation la fonctionnalité realtime de supabase pour que les utilisateurs voient les nouveaux articles et commentaires en temps réel sans avoir à rafraîchir la page. (2)
    - Implémenter en plus, une page qui permet de voir ces statistiques: nombre total de posts, nombre moyen de commentaires par post, nombre moyen de posts par utilisateur. (3)
    - Héberger le frontend (sur github pages exemple) (2).

Vous pouvez utiliser l'IA pour vous aider à créer votre application, mais vous devez être capable de justifier les choix que vous avez faits et de comprendre le code que vous avez écrit.