variable "viewer_svc" {
  type = any
}

variable "namespace" {
  description = "Kubernetes namespace for the gateway"
  type        = string
  default     = "gateway-ns"
}
