/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  plugins: [
    require('@tailwindcss/forms'),
    require("daisyui")],
  daisyui:{
    themes:["pastel"]
  }
}
