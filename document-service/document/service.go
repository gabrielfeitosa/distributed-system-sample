package document

import (
	"net/http"
	"time"

	"github.com/gin-gonic/gin"
)

type Service struct {
	documents map[string]Document
}

func NewService() *Service {
	return &Service{
		documents: initDatabase(),
	}
}

func initDatabase() map[string]Document {
	return map[string]Document{
		"valid": {
			Id:    "valid",
			Valid: true,
		},
		"invalid": {
			Id:    "invalid",
			Valid: false,
		},
		"delay": {
			Id:    "delay",
			Valid: true,
		},
	}
}

func (s Service) GetDocument(c *gin.Context) {
	docID := c.Param("id")
	if docID == "delay" {
		time.Sleep(3 * time.Second)
	}
	if docID == "error" {
		c.Status(http.StatusInternalServerError)
		return
	}
	if document, ok := s.documents[docID]; ok {
		c.JSON(http.StatusOK, document)
		return
	}
	c.Status(http.StatusNotFound)
}
