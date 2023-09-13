"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.locationSchema = void 0;
const mongoose_1 = require("mongoose");
exports.locationSchema = new mongoose_1.Schema({
    _id: { type: Number, required: true },
    name: { type: String, required: true },
    type: { type: String, required: true },
    dimension: { type: String, required: true },
    residents: [{ type: Number, ref: 'Character' }],
});
