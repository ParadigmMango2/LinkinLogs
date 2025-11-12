resource "kubernetes_secret" "jenkins_credentials" {
  metadata {
    name      = "jenkinswatcher-jenkins-credentials"
    namespace = var.namespace
  }

  data = {
    JENKINS_PROTOCOL = var.jenkins_protocol
    JENKINS_URL      = var.jenkins_url
    JENKINS_PORT     = var.jenkins_port
    JENKINS_USER     = var.jenkins_user
    JENKINS_TOKEN    = var.jenkins_token
  }

  type = "Opaque"
}

