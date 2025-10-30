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
