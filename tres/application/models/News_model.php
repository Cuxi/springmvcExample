<?php
class News_model extends CI_Model {

        public function __construct()
        {
                $this->load->database();
        }
	
	public function get_news($slug = FALSE)
	{

		$redis=new Redis();
        $redis->pconnect('127.0.0.1',6379);

		if ($slug === FALSE)
		{
		        $query = $this->redis->hgetall('news');
		        header('Content-type: application/json');
        		return json_encode($query);
		}

		$query = $this->redis->hgetall('news');
		header('Content-type: application/json');
        return json_encode($query);
		//return $query->row_array();
	}


	public function set_news()
{
	    $this->load->helper('url');

	    $slug = url_title($this->input->post('title'), 'dash', TRUE);

	    $data = array(
		'title' => $this->input->post('title'),
		'slug' => $slug,
		'text' => $this->input->post('text')
	    );

	    return $this->db->insert('news', $data);
	}

	
	public function delete_news()
	{
		$this->load->helper('url');

		$slug = url_title($this->input->post('title'), 'dash', TRUE);
			
		$this->db->where("slug", $slug);
		$this->db->delete('news');
		return $this->db->affected_rows();
	}

	public function update_news()
	{
		$this->load->helper('url');

		$slug = url_title($this->input->post('title'), 'dash', TRUE);

	    $data = array('slug' => $slug,
		'text' => $this->input->post('text')
	    );

		$this->db->where("slug", $slug);
		$this->db->update('news', $data);
		return $this->db->affected_rows();
	}
}
