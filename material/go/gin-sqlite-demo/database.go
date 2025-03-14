package main

import (
	"database/sql"
	"log"
)

var db *sql.DB

func setupDatabase() {
	localDb, err := sql.Open("sqlite", "./db.sqlite")
	if err != nil {
		log.Fatal(err)
		panic("Failed to load database")
	}

	// get SQLite version
	row := localDb.QueryRow("select sqlite_version()")

	println(row)
	db = localDb

	createTables()
}

func createTables() {
	db.Exec(`CREATE TABLE IF NOT EXISTS ALBUM (
    ID VARCHAR(100), Title VARCHAR(100), Artist VARCHAR(100), Price REAL
    )`)
}

func resetTables() {
	db.Exec(`Drop table if exists ALBUM`)
	createTables()
}

func insertAlbum(album *Album) error {
	_, err := db.Exec("INSERT INTO Album Values (?, ?, ?, ?)",
		album.ID, album.Title, album.Artist, album.Price)
	return err
}
