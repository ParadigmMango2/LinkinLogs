variable "jenkins_db_password" {
  description = "Postgres user password for the Jenkins service"
  type        = string
  sensitive   = true
}

variable "jenkins_db_admin_password" {
  description = "Postgres admin password for the Jenkins service"
  type        = string
  sensitive   = true
}

variable "jenkins_protocol" {
  description = "Protocol for Jenkins connection (http or https)"
  type        = string
  default     = "http"
}

variable "jenkins_url" {
  description = "Jenkins server URL or hostname"
  type        = string
  sensitive   = false
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
