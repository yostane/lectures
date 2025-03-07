import assert from 'assert';
import { Given, When, Then } from '@cucumber/cucumber';
import { isItFriday } from "../../src/Helper.js"

Given('today is {string}', function (day) {
  this.today = day;
});

When('I ask whether it\'s Friday yet', function () {
  this.actualAnswer = isItFriday(this.today);
});

Then('I should be told {string}', function (expectedAnswer) {
  assert.strictEqual(this.actualAnswer, expectedAnswer);
});