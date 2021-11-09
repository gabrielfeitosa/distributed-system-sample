package main

import (
	"document-service/document"

	"github.com/gin-gonic/gin"
)

func setupRouter() *gin.Engine {
	r := gin.Default()
	docSvc := document.NewService()
	r.GET("/document/:id", docSvc.GetDocument)
	return r
}
