package main

import (
	"net/http"
	"time"

	"github.com/gin-gonic/gin"
)

type Document struct {
	Id    string `json:"document"`
	Valid bool   `json:"valid"`
}

var documents = make(map[string]Document)

func init() {
	docs := []Document{
		{
			Id:    "valid",
			Valid: true,
		},
		{
			Id:    "invalid",
			Valid: false,
		},
		{
			Id:    "delay",
			Valid: true,
		},
	}

	for _, d := range docs {
		documents[d.Id] = d
	}

}

func setupRouter() *gin.Engine {
	r := gin.Default()
	r.GET("/document/:id", func(c *gin.Context) {
		docID := c.Param("id")
		if docID == "delay" {
			time.Sleep(3 * time.Second)
		}
		if docID == "error" {
			c.Status(http.StatusInternalServerError)
			return
		}
		if document, ok := documents[docID]; ok {
			c.JSON(http.StatusOK, document)
			return
		}
		c.Status(http.StatusNotFound)
	})
	return r
}

func main() {
	r := setupRouter()
	r.Run()
}
