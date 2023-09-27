"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
const getCharactersList_1 = __importDefault(require("./getCharactersList"));
const getCharacter_1 = __importDefault(require("./getCharacter"));
module.exports = {
    getCharactersList: getCharactersList_1.default,
    getCharacter: getCharacter_1.default,
};