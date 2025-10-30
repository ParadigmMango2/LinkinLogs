variable "name" {
  type = string
}

variable "namespace" {
  type = string
}

variable "postgres_user" {
  type = string
}

variable "postgres_password" {
  type = string
  sensitive = true
}

variable "postgres_db" {
  type = string
}
