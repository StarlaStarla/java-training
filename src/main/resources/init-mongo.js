db = db.getSiblingDB('crossskill');

//db.createUser({
//  user 'test',
//  pwd 'test',
//  roles [{ role 'readWrite', db 'crossskill' }],
//});

db.mycollection.insert({
  data: 'document data'
});