# Build and manage the Docker image
resource "docker_image" "calculator" {
  name = "calculator:latest"
  build {
    context    = "D:/Allgemein/Studium/Semester_5/Cont_Del/ContDel-Calculator/basicCalculator-ContDel-Techdemo"    
    dockerfile = "terraform/Dockerfile" # Points to Dockerfile
    no_cache   = true
  }
}

resource "docker_container" "calculator_container" {
  name  = "calculator-container"
  image = docker_image.calculator.image_id
}