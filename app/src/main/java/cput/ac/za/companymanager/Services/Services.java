package cput.ac.za.companymanager.Services;

import java.util.List;

/**
 * Created by yusraAdmin on 9/25/2015.
 */
public interface Services<S, ID> {

    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
