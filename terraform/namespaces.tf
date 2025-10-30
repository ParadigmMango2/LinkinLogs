/*
resource "kubernetes_namespace" "nginx" {
  metadata {
    name = "nginx-ns"
  }
}
*/

resource "kubernetes_namespace" "jenkins" {
  metadata {
    name = "jenkins-ns"
  }
}
