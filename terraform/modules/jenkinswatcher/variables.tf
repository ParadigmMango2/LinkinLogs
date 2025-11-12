variable "replicas" {
  type = number
  default = 1
}

variable "pg_secret" {
  sensitive = true
}

variable "jenkins_protocol" {
  description = "Protocol for Jenkins connection (http or https)"
  type        = string
  default     = "http"
}

variable "jenkins_url" {
  description = "Jenkins server URL or hostname"
  type        = string
}

variable "jenkins_port" {
  description = "Jenkins server port"
  type        = string
  default     = "8080"
}

variable "jenkins_user" {
  description = "Jenkins username for authentication"
  type        = string
  sensitive   = true
}

variable "jenkins_token" {
  description = "Jenkins API token for authentication"
  type        = string
  sensitive   = true
}

variable "namespace" {
  description = "Kubernetes namespace for the jenkinswatcher"
  type        = string
  default     = "jenkins-ns"
}
