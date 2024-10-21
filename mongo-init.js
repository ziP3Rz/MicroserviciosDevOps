db = db.getSiblingDB('inventario');
db.createUser({
  user: 'inventario',
  pwd: 'mcP4ss',
  roles: [{ role: 'readWrite', db: 'inventario' }]
});
