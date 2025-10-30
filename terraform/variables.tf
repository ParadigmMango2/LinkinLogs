variable "jenkins_db_password" {
  description = "Postgres password for the Jenkins service"
  type        = string
  sensitive   = true
}
