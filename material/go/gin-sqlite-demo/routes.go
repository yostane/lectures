package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

// getAlbums responds with the list of all albums as JSON.
func getAlbums(c *gin.Context) {
	// An albums slice to hold data from returned rows.
	albums := make([]Album, 0)

	rows, err := db.Query("SELECT * FROM album")
	if err != nil {
		// Renvoyer une réponse au client
		c.AbortWithStatus(http.StatusInternalServerError)
		// Quitter la fonction
		return
	}
	defer rows.Close()
	// Loop through rows, using Scan to assign column data to struct fields.
	for rows.Next() {
		var alb Album
		if err := rows.Scan(&alb.ID, &alb.Title, &alb.Artist, &alb.Price); err != nil {
			c.AbortWithStatus(http.StatusInternalServerError)
			return
		}
		albums = append(albums, alb)
	}
	if err := rows.Err(); err != nil {
		c.AbortWithStatus(http.StatusInternalServerError)
		return
	}
	c.IndentedJSON(http.StatusOK, albums)
}

// postAlbums adds an album from JSON received in the request body.
func postAlbums(c *gin.Context) {
	var newAlbum Album

	// Call BindJSON to bind the received JSON to
	// newAlbum.
	if err := c.BindJSON(&newAlbum); err != nil {
		c.AbortWithStatus(http.StatusBadRequest)
		return
	}
	// Insertion en bdd
	if err := insertAlbum(&newAlbum); err != nil {
		c.AbortWithStatus(http.StatusInternalServerError)
		return
	}
	c.IndentedJSON(http.StatusCreated, newAlbum)
}

func getAlbumByID(c *gin.Context) {
	id := c.Param("id")

	for _, album := range albums {
		if album.ID == id {
			c.IndentedJSON(http.StatusOK, album)
			return
		}
	}
	c.IndentedJSON(http.StatusNotFound, gin.H{"message": "album not found"})
}
