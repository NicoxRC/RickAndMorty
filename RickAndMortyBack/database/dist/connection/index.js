"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
const mongoose_1 = __importDefault(require("mongoose"));
const index_1 = __importDefault(require("../config/index"));
const characterSchema_1 = require("../schema/characterSchema");
const connection = mongoose_1.default.createConnection(String(index_1.default.MONGO_URI));
module.exports = {
    Character: connection.model('Character', characterSchema_1.characterSchema),
};
