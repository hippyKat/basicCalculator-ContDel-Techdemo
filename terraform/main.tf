resource "docker_image" "calculator" {
  name = "${var.app_name}:latest"
  build {
    context = ".."
    dockerfile = "../Dockerfile"
  }
}

resource "docker_container" "calculator_container" {
  name  = "${var.app_name}-container"
  image = docker_image.calculator.image_id
  
  ports {
    internal = 8080
    external = 8080
  }
}