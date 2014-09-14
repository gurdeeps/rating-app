package com.rateme.search;

import com.rateme.dao.UserDAO;
import com.rateme.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class SearchService {
    private AdjacencyList adjacencyList;
    private SymbolTable symbolTable;

    @Autowired
    private UserDAO userDAO;
    private boolean initialized;

    void init() {
        int numUsers = userDAO.getCount();
        symbolTable = new SymbolTable(numUsers);
        adjacencyList = new AdjacencyList(numUsers);
        List<User> users = userDAO.getAllUsers();
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            symbolTable.add(i, user.getId());
        }

        for(User user : users) {
            int userIndex = symbolTable.getIndex(user.getId());
            String managerId = user.getManagerId();
            if(!managerId.isEmpty()) {
                int managerIndex = symbolTable.getIndex(managerId);
                if(managerIndex != -1) {
                    adjacencyList.addEdge(userIndex, managerIndex);
                }
            }
        }
        initialized = true;
    }

    public List<User> getMatches(String gusId) {
        if(!initialized) {
            init();
        }
        int index = symbolTable.getIndex(gusId);
        BFS bfs = new BFS(adjacencyList, index);

        List<Integer> neighbours =  bfs.getNeighbours();
        List<User> matches = new ArrayList<User>();
        for(Integer key : neighbours) {
            String neighbourGusId = symbolTable.getGusId(key);
            User match = userDAO.getUserById(neighbourGusId);
            matches.add(match);
        }
        return matches;
    }
}
