<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PT-Linker</title>
    <style>
        body {
            background-color: white;
            margin: 0;
            padding: 0;
            font-family: sans-serif;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column; /* Modifica per schermi piccoli */
        }

        .content {
            display: flex;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            flex-wrap: wrap; /* Permette di avvolgere le sezioni */
            justify-content: center; /* Centra le sezioni */
        }

        .section {
            width: 300px;
            margin: 0 20px;
        }

        .section h2 {
            font-size: 1.5rem;
            margin-bottom: 10px;
        }

        .section ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .section li {
            border-bottom: 1px solid #ccc;
            padding: 10px 0;
        }

        .section li:last-child {
            border-bottom: none;
        }

        .header {
            background-color: orange;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: white;
        }

        .header h1 {
            margin: 0;
            font-size: 1.5rem;
        }

        .header .user {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .header .user .icon {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            background-image: url('image/icona-profilo.jpg'); /* Aggiungere l'icona profilo */
            background-size: cover;
        }

        .header .user a {
            text-decoration: none; /* Rimuove la sottolineatura dal link */
            color: white; /* Colore del testo */
            display: flex; /* Allinea l'icona e il testo */
            align-items: center; /* Centra verticalmente */
        }

        .header .user a span {
            margin-left: 5px; /* Spazio tra l'icona e il testo */
        }

        /* Media Queries per la responsività */
        @media (max-width: 768px) {
            .header {
                flex-direction: column; /* Imposta la direzione della flexbox in colonna */
                align-items: flex-start; /* Allinea gli elementi a sinistra */
            }

            .header h1 {
                font-size: 1.2rem; /* Riduce la dimensione del titolo */
            }

            .section {
                width: 100%; /* Le sezioni occupano tutta la larghezza */
                margin: 10px 0; /* Margine verticale tra le sezioni */
            }

            .content {
                flex-direction: column; /* Le sezioni si dispongono in colonna */
                align-items: center; /* Centra le sezioni */
            }
        }

        @media (max-width: 480px) {
            .header h1 {
                font-size: 1rem; /* Ulteriore riduzione della dimensione del titolo */
            }

            .header .user .icon {
                width: 25px; /* Riduce la dimensione dell'icona */
                height: 25px; /* Riduce la dimensione dell'icona */
            }

            .header .user a span {
                font-size: 0.9rem; /* Riduce la dimensione del testo "Accedi" */
            }
        }
    </style>
</head>
<body>
<div class="header">
    <h1>PT-Linker</h1>
    <div class="user">
        <a href="LoginServlet"> <!-- Modifica qui per collegare alla pagina di login -->
            <div class="icon"></div>
            <span>Accedi</span> <!-- Aggiunta della scritta "Accedi" -->
        </a>
    </div>
</div>
<div class="container">
    <div class="welcome">
        <h1>Benvenuto</h1>
    </div>
    <div class="content">
        <div class="section">
            <h2>Chi siamo?</h2>
            <p></p>
        </div>
        <div class="section">
            <h2>Perché PT-Linker</h2>
            <p></p>
        </div>
    </div>
</div>
</body>
</html>