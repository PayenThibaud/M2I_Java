package repository;

import entity.Client;

public class ClientRepository extends BaseRepository<Client> {

    public ClientRepository() {
        super(Client.class);
    }
}