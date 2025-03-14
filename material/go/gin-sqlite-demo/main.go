package main

import (
	"github.com/gin-gonic/gin"

	_ "github.com/glebarez/go-sqlite"
)

func main() {
	setupDatabase()
	router := gin.Default()
	router.GET("/albums", getAlbums)
	router.GET("/albums/:id", getAlbumByID)
	router.POST("/albums", postAlbums)

	router.Run("localhost:8080")
}
