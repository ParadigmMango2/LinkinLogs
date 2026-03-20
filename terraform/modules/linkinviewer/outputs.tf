output "viewer_svc" {
  value = kubernetes_service.linkin-viewer-svc
  description = "The viewer kubernetes service."
}
