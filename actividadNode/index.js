console.log("Hola Mundo desde Node.js Aitor Gutierrez");

import chalk from 'chalk';
import moment from 'moment';

console.log(chalk.blue("Texto azul"));
console.log(chalk.green("Texto verde"));
console.log(chalk.red.bold("Texto rojo y en negrita"));


console.log("Fecha actual:", moment().format("YYYY-MM-DD HH:mm:ss"));