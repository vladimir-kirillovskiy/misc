console.log(process.pid);
console.log(process.argv);
console.log(process.versions.node);

const [ , , firstName, lastName]  = process.argv;
// node globalProcess.js Vlad k
console.log(`Your name is ${firstName} ${lastName}`);

// node globalProcess.js --user Vlad --greating "Yo Yo Yo"
const grab = flag => {
    let indexAfterFlag = process.argv.indexOf(flag) + 1;
    return process.argv[indexAfterFlag]; 
}

const greeting = grab("--greeting");
const user = grab("--user");

console.log(`${greeting} ${user}`);
