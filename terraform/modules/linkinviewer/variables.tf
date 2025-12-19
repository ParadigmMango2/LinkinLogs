variable "replicas" {
  type = number
  default = 1
}

variable "namespace" {
  description = "Kubernetes namespace for the linkin viewer"
  type        = string
  default     = "viewer-ns"
}
