# MicroPython ESP32

- Créer et activer un environnement virtuel avec VSCode ou en ligne de commande

    ```bash
    # Sur mac et Linux
    python -m venv .venv
    source .venv/bin/activate
    ```

    ```pwsh
    # Sur Windows avec PowerShell
    python -m venv .venv
    .venv\Scripts\Activate.ps1
    ```

- Lancer l'installation des dépendances

    ```bash
    pip install -r requirements.txt
    ```

- Lancer le simulateur Wokwi depuis la console VSCode

    ```python
    python -m mpremote connect port:rfc2217://localhost:4000 run [fichier_python.py]
    # Si vous avez d'autres fichiers python que main (par exemple constants.py)
    python -m mpremote connect port:rfc2217://localhost:4000 fs cp constants.py :constants.py + run main.py
    ```
