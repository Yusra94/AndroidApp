package cput.ac.za.companymanager.Repositories;

import java.util.List;

/**
 * Created by yusraAdmin on 9/25/2015.
 */
public interface RestAPI<S, ID> {
    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
