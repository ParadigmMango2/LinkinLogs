variable "replicas" {
  type = number
  default = 1
}

variable "pg_secret" {
  sensitive = true
}
